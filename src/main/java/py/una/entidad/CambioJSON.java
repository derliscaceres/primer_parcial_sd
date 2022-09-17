package py.una.entidad;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CambioJSON {


    public static void main(String[] args) throws Exception {
    	CambioJSON representacion = new CambioJSON();
    	
    	System.out.println("Ejemplo de uso 1: pasar de objeto a string");
    	Cambio p = new Cambio();
    	p.setCompra(6850L);
    	p.setVenta(6900L);
    	p.setIdenti("Kerosen");
    	
    	String r1 = representacion.objetoString(p);
    	System.out.println(r1);
    	
    	
    	System.out.println("\n*************************************************************************");
    	System.out.println("\nEjemplo de uso 2: pasar de string a objeto");
    	String un_string = "{\"identi\":123123,\"Compra\":\"Ana\",\"Venta\":\"Perez\",\"asignaturas\":[\"Sistemas Distribuidos\",\"Fisica\",\"Inteligencia Artificial\"]}";
    	
    	Cambio r2 = representacion.stringObjeto(un_string);
    	System.out.println(r2.compra + " " + r2.venta + " " +r2.identi );
    }
    
    public static String objetoString(Cambio p) {	
    	
		JSONObject obj = new JSONObject();
        obj.put("identi", p.getIdenti());
        obj.put("compra", p.getCompra());
        obj.put("venta", p.getVenta());        

        return obj.toJSONString();
    }
    
    
    public static Cambio stringObjeto(String str) throws Exception {
    	Cambio p = new Cambio();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;

        /*int identi =(Integer)jsonObject.get("Identi");
        p.setIdenti(identi);*/
        p.setIdenti((String) jsonObject.get("identi"));
        p.setCompra((Long)jsonObject.get("compra"));
        p.setVenta((Long)jsonObject.get("venta"));
                
        return p;
	}

}
