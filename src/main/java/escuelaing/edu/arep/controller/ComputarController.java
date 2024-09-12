package escuelaing.edu.arep.controller;

import escuelaing.edu.arep.anotation.GetMapping;
import escuelaing.edu.arep.anotation.RequestValue;
import escuelaing.edu.arep.anotation.RestController;
import escuelaing.edu.arep.service.ComputarService;
import escuelaing.edu.arep.tools.Response;

import java.util.Arrays;

@RestController
public class ComputarController {
    private static final ComputarService computarService= new ComputarService();

    /**
     *
     * @param comando
     * @return
     */
    @GetMapping("/computar")
    public static Response  getComputarOpt(@RequestValue("comando") String comando){
        String[] list;
        if(comando.startsWith("bbl")){
            comando = comando.replace("bbl","");
            list = comando.split(",");
            String[] res = computarService.bubblesort(list);
            return new Response("application/json","OK","202", Arrays.toString(res));
        }else {
            list = comando.split(",");
        }
        try{
            String operation = list[0];
            float num1 = Float.parseFloat(list[1]);
            float num2 = Float.parseFloat(list[2]);
            Object value = computarService.operation(operation, num1, num2);
            if (value == null){
                return new Response("text/html","Number Not Valid ","404",null) ;
            }
            return new Response("application/json","OK","202", String.valueOf(value));
        }catch (Exception e){
            return new Response("text/html","Number Not Valid ","404",null) ;
        }
    }
}
