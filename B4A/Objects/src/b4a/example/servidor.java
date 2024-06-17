package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class servidor extends android.app.Service{
	public static class servidor_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (servidor) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, servidor.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static servidor mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return servidor.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.servidor");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.servidor", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (servidor) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			if (ServiceHelper.StarterHelper.runWaitForLayouts() == false) {
                BA.LogInfo("stopping spontaneous created service");
                stopSelf();
            }
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (servidor) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (servidor) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (servidor) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (servidor) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.HttpServer _websocket = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static anywheresoftware.b4a.objects.collections.Map _tokensenmemoria = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return false;
}
public static String  _generartoken(String _token) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "generartoken", false))
	 {return ((String) Debug.delegate(processBA, "generartoken", new Object[] {_token}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _caracteres = "";
long _timestamp = 0L;
int _i = 0;
int _indice = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub GenerarToken(token As String)";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim caracteres As String = \"ABCDEFGHIJKLMNOPQRSTU";
_caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim timestamp As Long = DateTime.Now";
_timestamp = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="For i = 1 To 32";
{
final int step5 = 1;
final int limit5 = (int) (32);
_i = (int) (1) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Dim indice As Int = timestamp Mod caracteres.Len";
_indice = (int) (_timestamp%_caracteres.length());
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="sb.Append(caracteres.CharAt(indice))";
_sb.Append(BA.ObjectToString(_caracteres.charAt(_indice)));
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="timestamp = timestamp / caracteres.Length";
_timestamp = (long) (_timestamp/(double)_caracteres.length());
 }
};
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="token = sb.ToString";
_token = _sb.ToString();
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="End Sub";
return "";
}
public static String  _handledatainput(anywheresoftware.b4a.objects.Servlet.ServletRequestWrapper _request,anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "handledatainput", false))
	 {return ((String) Debug.delegate(processBA, "handledatainput", new Object[] {_request,_response}));}
String _token = "";
String _cedula = "";
String _nombres = "";
double _salario = 0;
String _cargo = "";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub HandleDataInput(Request As ServletRequ";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim token As String = Request.GetParameter(\"token";
_token = _request.GetParameter("token");
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="If ValidarToken(token) Then";
if (_validartoken(_token)) { 
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim cedula As String = Request.GetParameter(\"ced";
_cedula = _request.GetParameter("cedula");
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="Dim nombres As String = Request.GetParameter(\"no";
_nombres = _request.GetParameter("nombres");
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="Dim salario As Double = Request.GetParameter(\"sa";
_salario = (double)(Double.parseDouble(_request.GetParameter("salario")));
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="Dim cargo As String = Request.GetParameter(\"carg";
_cargo = _request.GetParameter("cargo");
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO data (cedula, nom";
_sql.ExecNonQuery2("INSERT INTO data (cedula, nombres, salario, cargo) VALUES (?, ?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_cedula),(Object)(_nombres),(Object)(_salario),(Object)(_cargo)}));
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="Response.SendString(\"Datos Ingresados Correctame";
_response.SendString("Datos Ingresados Correctamente");
 }else {
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="Response.Status = 403";
_response.setStatus((int) (403));
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="Response.SendString(\"Debes inciar sesion para po";
_response.SendString("Debes inciar sesion para poder ingresar datos");
 };
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="End Sub";
return "";
}
public static boolean  _validartoken(String _token) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "validartoken", false))
	 {return ((Boolean) Debug.delegate(processBA, "validartoken", new Object[] {_token}));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub ValidarToken(token As String) As Boole";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Return tokensEnMemoria.ContainsKey(token)";
if (true) return _tokensenmemoria.ContainsKey((Object)(_token));
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return false;
}
public static String  _handledataoutput(anywheresoftware.b4a.objects.Servlet.ServletRequestWrapper _request,anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "handledataoutput", false))
	 {return ((String) Debug.delegate(processBA, "handledataoutput", new Object[] {_request,_response}));}
String _token = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.objects.collections.List _data = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _row = null;
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
String _json = "";
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub HandleDataOutput(Request As ServletReq";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim token As String = Request.GetParameter(\"token";
_token = _request.GetParameter("token");
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="If ValidarToken(token) Then";
if (_validartoken(_token)) { 
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim cursor As Cursor = sql.ExecQuery(\"SELECT * F";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_cursor = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sql.ExecQuery("SELECT * FROM data")));
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Dim data As List";
_data = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="For i = 0 To cursor.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_cursor.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="cursor.Position = i";
_cursor.setPosition(_i);
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="Dim row As Map";
_row = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="row.Initialize";
_row.Initialize();
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="row.Put(\"cedula\", cursor.GetString(\"cedula\"))";
_row.Put((Object)("cedula"),(Object)(_cursor.GetString("cedula")));
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="row.Put(\"nombres\", cursor.GetString(\"nombres\"))";
_row.Put((Object)("nombres"),(Object)(_cursor.GetString("nombres")));
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="row.Put(\"salario\", cursor.GetDouble(\"salario\"))";
_row.Put((Object)("salario"),(Object)(_cursor.GetDouble("salario")));
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="row.Put(\"cargo\", cursor.GetString(\"cargo\"))";
_row.Put((Object)("cargo"),(Object)(_cursor.GetString("cargo")));
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="data.Add(row)";
_data.Add((Object)(_row.getObject()));
 }
};
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="jsonGenerator.Initialize2(data)";
_jsongenerator.Initialize2(_data);
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="Dim json As String = jsonGenerator.ToPrettyStrin";
_json = _jsongenerator.ToPrettyString((int) (5));
RDebugUtils.currentLine=1638419;
 //BA.debugLineNum = 1638419;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1638420;
 //BA.debugLineNum = 1638420;BA.debugLine="Response.SendString(json)";
_response.SendString(_json);
 }else {
RDebugUtils.currentLine=1638422;
 //BA.debugLineNum = 1638422;BA.debugLine="Response.Status = 403";
_response.setStatus((int) (403));
RDebugUtils.currentLine=1638423;
 //BA.debugLineNum = 1638423;BA.debugLine="Response.SendString(\"Debes inciar sesion para po";
_response.SendString("Debes inciar sesion para poder ver los datos guardados");
 };
RDebugUtils.currentLine=1638425;
 //BA.debugLineNum = 1638425;BA.debugLine="End Sub";
return "";
}
public static String  _handlehome(anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "handlehome", false))
	 {return ((String) Debug.delegate(processBA, "handlehome", new Object[] {_response}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub HandleHome( Response As ServletRespons";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="ServeFile(Response, \"home.html\")";
_servefile(_response,"home.html");
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _servefile(anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response,String _filename) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "servefile", false))
	 {return ((String) Debug.delegate(processBA, "servefile", new Object[] {_response,_filename}));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub ServeFile(Response As ServletResponse,";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If File.Exists(File.DirAssets, FileName) Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename)) { 
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Response.SendFile(File.DirAssets, FileName)";
_response.SendFile(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename);
 }else {
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="Response.Status = 404";
_response.setStatus((int) (404));
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="Response.SendString(\"Archivo no encontrado\")";
_response.SendString("Archivo no encontrado");
 };
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="End Sub";
return "";
}
public static String  _handlelogin(anywheresoftware.b4a.objects.Servlet.ServletRequestWrapper _request,anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "handlelogin", false))
	 {return ((String) Debug.delegate(processBA, "handlelogin", new Object[] {_request,_response}));}
String _username = "";
String _password = "";
String _ip = "";
String _token = "";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub HandleLogin(Request As ServletRequest,";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim username As String = Request.GetParameter(\"us";
_username = _request.GetParameter("username");
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim password As String = Request.GetParameter(\"pa";
_password = _request.GetParameter("password");
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim ip As String = Request.RemoteAddress";
_ip = _request.getRemoteAddress();
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Dim token As String";
_token = "";
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="GenerarToken(token)";
_generartoken(_token);
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="tokensEnMemoria.Put(token, ip)";
_tokensenmemoria.Put((Object)(_token),(Object)(_ip));
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="sql.ExecNonQuery2(\"INSERT INTO users (username, p";
_sql.ExecNonQuery2("INSERT INTO users (username, password, ip) VALUES (?, ?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_username),(Object)(_password),(Object)(_ip)}));
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Response.SendString(\"Login exitoso. TU IP address";
_response.SendString("Login exitoso. TU IP address es: "+_ip);
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="webSocket.Initialize(\"webSocket\")";
_websocket.Initialize(processBA,"webSocket");
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="sql.Initialize(File.DirInternal, \"data.db\", True)";
_sql.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS user";
_sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT, ip TEXT)");
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="sql.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS data";
_sql.ExecNonQuery("CREATE TABLE IF NOT EXISTS data (cedula TEXT, nombres TEXT, salario REAL, cargo TEXT)");
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="tokensEnMemoria.Initialize";
_tokensenmemoria.Initialize();
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="webSocket.Start(8080)";
_websocket.Start((int) (8080));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="webSocket.Stop";
_websocket.Stop();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _websocket_handlerequest(anywheresoftware.b4a.objects.Servlet.ServletRequestWrapper _request,anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="servidor";
if (Debug.shouldDelegate(processBA, "websocket_handlerequest", false))
	 {return ((String) Debug.delegate(processBA, "websocket_handlerequest", new Object[] {_request,_response}));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub webSocket_HandleRequest (Request As Se";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Select Request.RequestURI";
switch (BA.switchObjectToInt(_request.getRequestURI(),"/home","/login","/DataInput","/DataOutput")) {
case 0: {
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="HandleHome(Response)";
_handlehome(_response);
 break; }
case 1: {
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="If Request.Method = \"GET\" Then";
if ((_request.getMethod()).equals("GET")) { 
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="ServeFile(Response, \"login.html\")";
_servefile(_response,"login.html");
 }else {
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="HandleLogin(Request, Response)";
_handlelogin(_request,_response);
 };
 break; }
case 2: {
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="If Request.Method = \"GET\" Then";
if ((_request.getMethod()).equals("GET")) { 
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="ServeFile(Response, \"datainput.html\")";
_servefile(_response,"datainput.html");
 }else {
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="HandleDataInput(Request, Response)";
_handledatainput(_request,_response);
 };
 break; }
case 3: {
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="HandleDataOutput(Request, Response)";
_handledataoutput(_request,_response);
 break; }
default: {
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="Response.Status = 404";
_response.setStatus((int) (404));
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="Response.SendString(\"Not Found\")";
_response.SendString("Not Found");
 break; }
}
;
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="End Sub";
return "";
}
}