B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=12.8
@EndOfDesignText@
#Region Service Attributes 
    #StartAtBoot: False
    #ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Private webSocket As HttpServer
	Private sql As SQL
	Private tokensEnMemoria As Map
End Sub

Sub Service_Create
	webSocket.Initialize("webSocket")
	sql.Initialize(File.DirInternal, "data.db", True)
	sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT, ip TEXT)")
	sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS data (cedula TEXT, nombres TEXT, salario REAL, cargo TEXT)")
	tokensEnMemoria.Initialize
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground
	webSocket.Start(8080)
End Sub

Sub Service_TaskRemoved
	webSocket.Stop
End Sub

Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Private Sub webSocket_HandleRequest (Request As ServletRequest, Response As ServletResponse)
	Select Request.RequestURI
		Case "/home"
			HandleHome(Response)
		Case "/login"
			If Request.Method = "GET" Then
				ServeFile(Response, "login.html")
			Else
				HandleLogin(Request, Response)
			End If
		Case "/DataInput"
			If Request.Method = "GET" Then
				ServeFile(Response, "datainput.html")
			Else
				HandleDataInput(Request, Response)
			End If
		Case "/DataOutput"
			HandleDataOutput(Request, Response)
		Case Else
			Response.Status = 404
			Response.SendString("Not Found")
	End Select
End Sub

Private Sub HandleHome( Response As ServletResponse)
	ServeFile(Response, "home.html")
End Sub

Private Sub GenerarToken(token As String)
	Dim sb As StringBuilder
	sb.Initialize
	Dim caracteres As String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
	Dim timestamp As Long = DateTime.Now
	For i = 1 To 32
		Dim indice As Int = timestamp Mod caracteres.Length
		sb.Append(caracteres.CharAt(indice))
		timestamp = timestamp / caracteres.Length
	Next
	token = sb.ToString
End Sub

Private Sub ValidarToken(token As String) As Boolean
    Return tokensEnMemoria.ContainsKey(token)
End Sub

Private Sub HandleLogin(Request As ServletRequest, Response As ServletResponse)
	Dim username As String = Request.GetParameter("username")
	Dim password As String = Request.GetParameter("password")
	Dim ip As String = Request.RemoteAddress

	Dim token As String
	GenerarToken(token)
	tokensEnMemoria.Put(token, ip)

	sql.ExecNonQuery2("INSERT INTO users (username, password, ip) VALUES (?, ?, ?)", Array As Object(username, password, ip))
	Response.Status = 200
	Response.SendString("Login exitoso. TU IP address es: " & ip)
End Sub

Private Sub HandleDataInput(Request As ServletRequest, Response As ServletResponse)
	Dim token As String = Request.GetParameter("token")
	If ValidarToken(token) Then
		Dim cedula As String = Request.GetParameter("cedula")
		Dim nombres As String = Request.GetParameter("nombres")
		Dim salario As Double = Request.GetParameter("salario")
		Dim cargo As String = Request.GetParameter("cargo")
		sql.ExecNonQuery2("INSERT INTO data (cedula, nombres, salario, cargo) VALUES (?, ?, ?, ?)", Array As Object(cedula, nombres, salario, cargo))
		Response.Status = 200
		Response.SendString("Datos Ingresados Correctamente")
	Else
		Response.Status = 403
		Response.SendString("Debes inciar sesion para poder ingresar datos")
	End If
End Sub

Private Sub HandleDataOutput(Request As ServletRequest, Response As ServletResponse)
	Dim token As String = Request.GetParameter("token")
	If ValidarToken(token) Then
		Dim cursor As Cursor = sql.ExecQuery("SELECT * FROM data")
		Dim data As List
		data.Initialize
		For i = 0 To cursor.RowCount - 1
			cursor.Position = i
			Dim row As Map
			row.Initialize
			row.Put("cedula", cursor.GetString("cedula"))
			row.Put("nombres", cursor.GetString("nombres"))
			row.Put("salario", cursor.GetDouble("salario"))
			row.Put("cargo", cursor.GetString("cargo"))
			data.Add(row)
		Next
		Dim jsonGenerator As JSONGenerator
		jsonGenerator.Initialize2(data)
		Dim json As String = jsonGenerator.ToPrettyString(5)
		Response.Status = 200
		Response.SendString(json)
	Else
		Response.Status = 403
		Response.SendString("Debes inciar sesion para poder ver los datos guardados")
	End If
End Sub

Private Sub ServeFile(Response As ServletResponse, FileName As String)
	If File.Exists(File.DirAssets, FileName) Then
		Response.Status = 200
		Response.SendFile(File.DirAssets, FileName)
	Else
		Response.Status = 404
		Response.SendString("Archivo no encontrado")
	End If
End Sub
