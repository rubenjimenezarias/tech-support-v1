import java.util.Random ;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    private ArrayList <String> respuestas;
    private HashMap<String, String> respuestasRuben;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        respuestas = new ArrayList<>();
        respuestasRuben = new HashMap<String, String>();
        cargarRespuestasAleatorias();
        cargarRespuestasRuben();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String pregunta)
    {
        String respuesta;
        if(respuestasRuben.containsKey(pregunta))
        {
            respuesta = respuestasRuben.get(pregunta);
        }
        else
        {
            Random aleatorio = new Random();
            int numeroAleatorio = aleatorio.nextInt(respuestas.size());
            respuesta = respuestas.get(numeroAleatorio);
        }
        
        return respuesta;
    }
    
    /**
     * Carga las respuestas aleatorias.
     */
    public void cargarRespuestasAleatorias()
    {
        respuestas.add("SI");
        respuestas.add("NO");
        respuestas.add("No te entiendo nada");
        respuestas.add("A mi no me vaciles eh!!");
        respuestas.add("Adios");
    }
    
    /**
     * Cargas las respuestas segun la palabra que ha indicado el usuario enel hasmap
     */
    public void cargarRespuestasRuben()
    {
        respuestasRuben.put("edad","a ti que te importa mi edad");
        respuestasRuben.put("coche","tengo un Ford");
        respuestasRuben.put("motos","me encantan las motos");
        respuestasRuben.put("futbol","soy del Real Madrid");
    }
    
}
