import java.util.Random ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    private HashMap<HashSet, String> respuestasRuben;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        respuestas = new ArrayList<>();
        respuestasRuben = new HashMap<HashSet, String>();
        cargarRespuestasAleatorias();
        cargarRespuestasRuben();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet pregunta)
    {
        String respuesta = null;
        HashSet<String> conjunto = pregunta;
        //Sacamos la palabra clave del conjunto HashSet
        if(respuestasRuben.containsKey(pregunta))
        {
            respuesta=respuestasRuben.get(pregunta);
        }
        if(respuesta == null)
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
        HashSet<String> freeapp = new HashSet<>();
        freeapp.add("free");
        freeapp.add("app");
        respuestasRuben.put(freeapp,"contiene freeapp");
        
        HashSet<String> problemlinuxcrash = new HashSet<>();
        problemlinuxcrash.add("problem");
        problemlinuxcrash.add("linux");
        problemlinuxcrash.add("crash");
        respuestasRuben.put(problemlinuxcrash,"PROBLEMA linux ha roto");
    }
    
}
