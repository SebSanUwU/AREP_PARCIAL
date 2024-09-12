package escuelaing.edu.arep;

import escuelaing.edu.arep.anotation.GetMapping;
import escuelaing.edu.arep.controller.ComputarController;
import escuelaing.edu.arep.tools.Response;


import java.lang.reflect.Method;
import java.net.*;
import java.io.*;
import java.util.HashMap;


public class HttpServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Cargar los metodos de las clases
        Class[] ListController = new Class[]{ComputarController.class};
        HashMap<String,Method> controllerService = new HashMap<>();
        for(Class<?> controller : ListController){
            Method[] allMethods = controller.getDeclaredMethods();
            for (Method m : allMethods) {
                if (m.isAnnotationPresent(GetMapping.class)) {
                    controllerService.put(m.getName(),m);
                }
            }
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println("Recibí: " + inputLine);
            String[] line = inputLine.split(" ");
            String method = line[0];
            if (method.startsWith("GET")){
                String basePath = line[1];
                handleRequest(basePath,out);
                System.out.println(line[0]);
                System.out.println(line[1]);
                System.out.println(line[2]);
                System.out.println(line.length);
            }
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static void handleRequest(String basePaht,PrintWriter out) {


    }

    /**
     * Respuesta exitosa de peticion
     * @param res Objeto de respuesta de la peticion
     * @return JSON con la descripcion de la peticion
     */
    public static String okResponse(Response res){
        return "{Status: "+ res.getStatus()+"\n" +
                "Code"+res.getCode()+"\n" +
                "ContentType : "+ res.getContentType()+"\n"+
                "Data: "+res.getData()+"}" ;
    }

    /**
     * Respuesta de error de peticion
     * @param res Objeto de respuesta de la peticion
     * @return JSON con la descripcion de la peticion
     */
    public static String errorResponse(Response res){
        return "{Status: "+ res.getStatus()+"\n" +
                "Code"+res.getCode()+"\n" +
                "ContentType : "+ res.getContentType()+"\n"+
                "}" ;
    }
}
