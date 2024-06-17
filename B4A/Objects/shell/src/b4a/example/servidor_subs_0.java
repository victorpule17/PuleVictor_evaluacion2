package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class servidor_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,29);
if (RapidSub.canDelegate("application_error")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 29;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Return True";
Debug.ShouldStop(536870912);
if (true) return servidor.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _generartoken(RemoteObject _token) throws Exception{
try {
		Debug.PushSubsStack("GenerarToken (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,65);
if (RapidSub.canDelegate("generartoken")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","generartoken", _token);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _caracteres = RemoteObject.createImmutable("");
RemoteObject _timestamp = RemoteObject.createImmutable(0L);
int _i = 0;
RemoteObject _indice = RemoteObject.createImmutable(0);
Debug.locals.put("token", _token);
 BA.debugLineNum = 65;BA.debugLine="Private Sub GenerarToken(token As String)";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(2);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 67;BA.debugLine="sb.Initialize";
Debug.ShouldStop(4);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 68;BA.debugLine="Dim caracteres As String = \"ABCDEFGHIJKLMNOPQRSTU";
Debug.ShouldStop(8);
_caracteres = BA.ObjectToString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");Debug.locals.put("caracteres", _caracteres);Debug.locals.put("caracteres", _caracteres);
 BA.debugLineNum = 69;BA.debugLine="Dim timestamp As Long = DateTime.Now";
Debug.ShouldStop(16);
_timestamp = servidor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("timestamp", _timestamp);Debug.locals.put("timestamp", _timestamp);
 BA.debugLineNum = 70;BA.debugLine="For i = 1 To 32";
Debug.ShouldStop(32);
{
final int step5 = 1;
final int limit5 = 32;
_i = 1 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 71;BA.debugLine="Dim indice As Int = timestamp Mod caracteres.Len";
Debug.ShouldStop(64);
_indice = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_timestamp,_caracteres.runMethod(true,"length")}, "%",0, 2));Debug.locals.put("indice", _indice);Debug.locals.put("indice", _indice);
 BA.debugLineNum = 72;BA.debugLine="sb.Append(caracteres.CharAt(indice))";
Debug.ShouldStop(128);
_sb.runVoidMethod ("Append",(Object)(BA.ObjectToString(_caracteres.runMethod(true,"charAt",(Object)(_indice)))));
 BA.debugLineNum = 73;BA.debugLine="timestamp = timestamp / caracteres.Length";
Debug.ShouldStop(256);
_timestamp = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {_timestamp,_caracteres.runMethod(true,"length")}, "/",0, 0));Debug.locals.put("timestamp", _timestamp);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 75;BA.debugLine="token = sb.ToString";
Debug.ShouldStop(1024);
_token = _sb.runMethod(true,"ToString");Debug.locals.put("token", _token);
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _handledatainput(RemoteObject _request,RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("HandleDataInput (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,96);
if (RapidSub.canDelegate("handledatainput")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","handledatainput", _request, _response);}
RemoteObject _token = RemoteObject.createImmutable("");
RemoteObject _cedula = RemoteObject.createImmutable("");
RemoteObject _nombres = RemoteObject.createImmutable("");
RemoteObject _salario = RemoteObject.createImmutable(0);
RemoteObject _cargo = RemoteObject.createImmutable("");
Debug.locals.put("Request", _request);
Debug.locals.put("Response", _response);
 BA.debugLineNum = 96;BA.debugLine="Private Sub HandleDataInput(Request As ServletRequ";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim token As String = Request.GetParameter(\"token";
Debug.ShouldStop(1);
_token = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("token")));Debug.locals.put("token", _token);Debug.locals.put("token", _token);
 BA.debugLineNum = 98;BA.debugLine="If ValidarToken(token) Then";
Debug.ShouldStop(2);
if (_validartoken(_token).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 99;BA.debugLine="Dim cedula As String = Request.GetParameter(\"ced";
Debug.ShouldStop(4);
_cedula = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("cedula")));Debug.locals.put("cedula", _cedula);Debug.locals.put("cedula", _cedula);
 BA.debugLineNum = 100;BA.debugLine="Dim nombres As String = Request.GetParameter(\"no";
Debug.ShouldStop(8);
_nombres = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("nombres")));Debug.locals.put("nombres", _nombres);Debug.locals.put("nombres", _nombres);
 BA.debugLineNum = 101;BA.debugLine="Dim salario As Double = Request.GetParameter(\"sa";
Debug.ShouldStop(16);
_salario = BA.numberCast(double.class, _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("salario"))));Debug.locals.put("salario", _salario);Debug.locals.put("salario", _salario);
 BA.debugLineNum = 102;BA.debugLine="Dim cargo As String = Request.GetParameter(\"carg";
Debug.ShouldStop(32);
_cargo = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("cargo")));Debug.locals.put("cargo", _cargo);Debug.locals.put("cargo", _cargo);
 BA.debugLineNum = 103;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO data (cedula, nom";
Debug.ShouldStop(64);
servidor._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO data (cedula, nombres, salario, cargo) VALUES (?, ?, ?, ?)")),(Object)(servidor.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_cedula),(_nombres),(_salario),(_cargo)})))));
 BA.debugLineNum = 104;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(128);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 105;BA.debugLine="Response.SendString(\"Datos Ingresados Correctame";
Debug.ShouldStop(256);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Datos Ingresados Correctamente")));
 }else {
 BA.debugLineNum = 107;BA.debugLine="Response.Status = 403";
Debug.ShouldStop(1024);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 403));
 BA.debugLineNum = 108;BA.debugLine="Response.SendString(\"Debes inciar sesion para po";
Debug.ShouldStop(2048);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Debes inciar sesion para poder ingresar datos")));
 };
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _handledataoutput(RemoteObject _request,RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("HandleDataOutput (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,112);
if (RapidSub.canDelegate("handledataoutput")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","handledataoutput", _request, _response);}
RemoteObject _token = RemoteObject.createImmutable("");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _row = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _json = RemoteObject.createImmutable("");
Debug.locals.put("Request", _request);
Debug.locals.put("Response", _response);
 BA.debugLineNum = 112;BA.debugLine="Private Sub HandleDataOutput(Request As ServletReq";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Dim token As String = Request.GetParameter(\"token";
Debug.ShouldStop(65536);
_token = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("token")));Debug.locals.put("token", _token);Debug.locals.put("token", _token);
 BA.debugLineNum = 114;BA.debugLine="If ValidarToken(token) Then";
Debug.ShouldStop(131072);
if (_validartoken(_token).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 115;BA.debugLine="Dim cursor As Cursor = sql.ExecQuery(\"SELECT * F";
Debug.ShouldStop(262144);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_cursor = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), servidor._sql.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM data"))));Debug.locals.put("cursor", _cursor);Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 116;BA.debugLine="Dim data As List";
Debug.ShouldStop(524288);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("data", _data);
 BA.debugLineNum = 117;BA.debugLine="data.Initialize";
Debug.ShouldStop(1048576);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 118;BA.debugLine="For i = 0 To cursor.RowCount - 1";
Debug.ShouldStop(2097152);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 119;BA.debugLine="cursor.Position = i";
Debug.ShouldStop(4194304);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 120;BA.debugLine="Dim row As Map";
Debug.ShouldStop(8388608);
_row = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("row", _row);
 BA.debugLineNum = 121;BA.debugLine="row.Initialize";
Debug.ShouldStop(16777216);
_row.runVoidMethod ("Initialize");
 BA.debugLineNum = 122;BA.debugLine="row.Put(\"cedula\", cursor.GetString(\"cedula\"))";
Debug.ShouldStop(33554432);
_row.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("cedula"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("cedula"))))));
 BA.debugLineNum = 123;BA.debugLine="row.Put(\"nombres\", cursor.GetString(\"nombres\"))";
Debug.ShouldStop(67108864);
_row.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("nombres"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("nombres"))))));
 BA.debugLineNum = 124;BA.debugLine="row.Put(\"salario\", cursor.GetDouble(\"salario\"))";
Debug.ShouldStop(134217728);
_row.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("salario"))),(Object)((_cursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("salario"))))));
 BA.debugLineNum = 125;BA.debugLine="row.Put(\"cargo\", cursor.GetString(\"cargo\"))";
Debug.ShouldStop(268435456);
_row.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("cargo"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("cargo"))))));
 BA.debugLineNum = 126;BA.debugLine="data.Add(row)";
Debug.ShouldStop(536870912);
_data.runVoidMethod ("Add",(Object)((_row.getObject())));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 128;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(-2147483648);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 129;BA.debugLine="jsonGenerator.Initialize2(data)";
Debug.ShouldStop(1);
_jsongenerator.runVoidMethod ("Initialize2",(Object)(_data));
 BA.debugLineNum = 130;BA.debugLine="Dim json As String = jsonGenerator.ToPrettyStrin";
Debug.ShouldStop(2);
_json = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("json", _json);Debug.locals.put("json", _json);
 BA.debugLineNum = 131;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(4);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 132;BA.debugLine="Response.SendString(json)";
Debug.ShouldStop(8);
_response.runVoidMethod ("SendString",(Object)(_json));
 }else {
 BA.debugLineNum = 134;BA.debugLine="Response.Status = 403";
Debug.ShouldStop(32);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 403));
 BA.debugLineNum = 135;BA.debugLine="Response.SendString(\"Debes inciar sesion para po";
Debug.ShouldStop(64);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Debes inciar sesion para poder ver los datos guardados")));
 };
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _handlehome(RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("HandleHome (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,61);
if (RapidSub.canDelegate("handlehome")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","handlehome", _response);}
Debug.locals.put("Response", _response);
 BA.debugLineNum = 61;BA.debugLine="Private Sub HandleHome( Response As ServletRespons";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 62;BA.debugLine="ServeFile(Response, \"home.html\")";
Debug.ShouldStop(536870912);
_servefile(_response,RemoteObject.createImmutable("home.html"));
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _handlelogin(RemoteObject _request,RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("HandleLogin (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,82);
if (RapidSub.canDelegate("handlelogin")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","handlelogin", _request, _response);}
RemoteObject _username = RemoteObject.createImmutable("");
RemoteObject _password = RemoteObject.createImmutable("");
RemoteObject _ip = RemoteObject.createImmutable("");
RemoteObject _token = RemoteObject.createImmutable("");
Debug.locals.put("Request", _request);
Debug.locals.put("Response", _response);
 BA.debugLineNum = 82;BA.debugLine="Private Sub HandleLogin(Request As ServletRequest,";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Dim username As String = Request.GetParameter(\"us";
Debug.ShouldStop(262144);
_username = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("username")));Debug.locals.put("username", _username);Debug.locals.put("username", _username);
 BA.debugLineNum = 84;BA.debugLine="Dim password As String = Request.GetParameter(\"pa";
Debug.ShouldStop(524288);
_password = _request.runMethod(true,"GetParameter",(Object)(RemoteObject.createImmutable("password")));Debug.locals.put("password", _password);Debug.locals.put("password", _password);
 BA.debugLineNum = 85;BA.debugLine="Dim ip As String = Request.RemoteAddress";
Debug.ShouldStop(1048576);
_ip = _request.runMethod(true,"getRemoteAddress");Debug.locals.put("ip", _ip);Debug.locals.put("ip", _ip);
 BA.debugLineNum = 87;BA.debugLine="Dim token As String";
Debug.ShouldStop(4194304);
_token = RemoteObject.createImmutable("");Debug.locals.put("token", _token);
 BA.debugLineNum = 88;BA.debugLine="GenerarToken(token)";
Debug.ShouldStop(8388608);
_generartoken(_token);
 BA.debugLineNum = 89;BA.debugLine="tokensEnMemoria.Put(token, ip)";
Debug.ShouldStop(16777216);
servidor._tokensenmemoria.runVoidMethod ("Put",(Object)((_token)),(Object)((_ip)));
 BA.debugLineNum = 91;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO users (username, p";
Debug.ShouldStop(67108864);
servidor._sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT INTO users (username, password, ip) VALUES (?, ?, ?)")),(Object)(servidor.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_username),(_password),(_ip)})))));
 BA.debugLineNum = 92;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(134217728);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 93;BA.debugLine="Response.SendString(\"Login exitoso. TU IP address";
Debug.ShouldStop(268435456);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Login exitoso. TU IP address es: "),_ip)));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private webSocket As HttpServer";
servidor._websocket = RemoteObject.createNew ("anywheresoftware.b4a.objects.HttpServer");
 //BA.debugLineNum = 8;BA.debugLine="Private sql As SQL";
servidor._sql = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 9;BA.debugLine="Private tokensEnMemoria As Map";
servidor._tokensenmemoria = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _servefile(RemoteObject _response,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("ServeFile (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,139);
if (RapidSub.canDelegate("servefile")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","servefile", _response, _filename);}
Debug.locals.put("Response", _response);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 139;BA.debugLine="Private Sub ServeFile(Response As ServletResponse,";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="If File.Exists(File.DirAssets, FileName) Then";
Debug.ShouldStop(2048);
if (servidor.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(servidor.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_filename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 141;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(4096);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 142;BA.debugLine="Response.SendFile(File.DirAssets, FileName)";
Debug.ShouldStop(8192);
_response.runVoidMethod ("SendFile",(Object)(servidor.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_filename));
 }else {
 BA.debugLineNum = 144;BA.debugLine="Response.Status = 404";
Debug.ShouldStop(32768);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 404));
 BA.debugLineNum = 145;BA.debugLine="Response.SendString(\"Archivo no encontrado\")";
Debug.ShouldStop(65536);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Archivo no encontrado")));
 };
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="webSocket.Initialize(\"webSocket\")";
Debug.ShouldStop(4096);
servidor._websocket.runVoidMethod ("Initialize",servidor.processBA,(Object)(RemoteObject.createImmutable("webSocket")));
 BA.debugLineNum = 14;BA.debugLine="sql.Initialize(File.DirInternal, \"data.db\", True)";
Debug.ShouldStop(8192);
servidor._sql.runVoidMethod ("Initialize",(Object)(servidor.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("data.db")),(Object)(servidor.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 15;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS user";
Debug.ShouldStop(16384);
servidor._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT, ip TEXT)")));
 BA.debugLineNum = 16;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS data";
Debug.ShouldStop(32768);
servidor._sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS data (cedula TEXT, nombres TEXT, salario REAL, cargo TEXT)")));
 BA.debugLineNum = 17;BA.debugLine="tokensEnMemoria.Initialize";
Debug.ShouldStop(65536);
servidor._tokensenmemoria.runVoidMethod ("Initialize");
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,33);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","service_destroy");}
 BA.debugLineNum = 33;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,20);
if (RapidSub.canDelegate("service_start")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Service.StopAutomaticForeground";
Debug.ShouldStop(1048576);
servidor.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 22;BA.debugLine="webSocket.Start(8080)";
Debug.ShouldStop(2097152);
servidor._websocket.runVoidMethod ("Start",(Object)(BA.numberCast(int.class, 8080)));
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,25);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","service_taskremoved");}
 BA.debugLineNum = 25;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="webSocket.Stop";
Debug.ShouldStop(33554432);
servidor._websocket.runVoidMethod ("Stop");
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _validartoken(RemoteObject _token) throws Exception{
try {
		Debug.PushSubsStack("ValidarToken (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,78);
if (RapidSub.canDelegate("validartoken")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","validartoken", _token);}
Debug.locals.put("token", _token);
 BA.debugLineNum = 78;BA.debugLine="Private Sub ValidarToken(token As String) As Boole";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Return tokensEnMemoria.ContainsKey(token)";
Debug.ShouldStop(16384);
if (true) return servidor._tokensenmemoria.runMethod(true,"ContainsKey",(Object)((_token)));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _websocket_handlerequest(RemoteObject _request,RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("webSocket_HandleRequest (servidor) ","servidor",2,servidor.processBA,servidor.mostCurrent,37);
if (RapidSub.canDelegate("websocket_handlerequest")) { return b4a.example.servidor.remoteMe.runUserSub(false, "servidor","websocket_handlerequest", _request, _response);}
Debug.locals.put("Request", _request);
Debug.locals.put("Response", _response);
 BA.debugLineNum = 37;BA.debugLine="Private Sub webSocket_HandleRequest (Request As Se";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Select Request.RequestURI";
Debug.ShouldStop(32);
switch (BA.switchObjectToInt(_request.runMethod(true,"getRequestURI"),BA.ObjectToString("/home"),BA.ObjectToString("/login"),BA.ObjectToString("/DataInput"),BA.ObjectToString("/DataOutput"))) {
case 0: {
 BA.debugLineNum = 40;BA.debugLine="HandleHome(Response)";
Debug.ShouldStop(128);
_handlehome(_response);
 break; }
case 1: {
 BA.debugLineNum = 42;BA.debugLine="If Request.Method = \"GET\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_request.runMethod(true,"getMethod"),BA.ObjectToString("GET"))) { 
 BA.debugLineNum = 43;BA.debugLine="ServeFile(Response, \"login.html\")";
Debug.ShouldStop(1024);
_servefile(_response,RemoteObject.createImmutable("login.html"));
 }else {
 BA.debugLineNum = 45;BA.debugLine="HandleLogin(Request, Response)";
Debug.ShouldStop(4096);
_handlelogin(_request,_response);
 };
 break; }
case 2: {
 BA.debugLineNum = 48;BA.debugLine="If Request.Method = \"GET\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_request.runMethod(true,"getMethod"),BA.ObjectToString("GET"))) { 
 BA.debugLineNum = 49;BA.debugLine="ServeFile(Response, \"datainput.html\")";
Debug.ShouldStop(65536);
_servefile(_response,RemoteObject.createImmutable("datainput.html"));
 }else {
 BA.debugLineNum = 51;BA.debugLine="HandleDataInput(Request, Response)";
Debug.ShouldStop(262144);
_handledatainput(_request,_response);
 };
 break; }
case 3: {
 BA.debugLineNum = 54;BA.debugLine="HandleDataOutput(Request, Response)";
Debug.ShouldStop(2097152);
_handledataoutput(_request,_response);
 break; }
default: {
 BA.debugLineNum = 56;BA.debugLine="Response.Status = 404";
Debug.ShouldStop(8388608);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 404));
 BA.debugLineNum = 57;BA.debugLine="Response.SendString(\"Not Found\")";
Debug.ShouldStop(16777216);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Not Found")));
 break; }
}
;
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}