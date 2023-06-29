
package BaseDatos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class baseDeDatos   {
    MySqlConn objConn=new  MySqlConn();

    public static void main(String ... args){
       baseDeDatos bd = new baseDeDatos();      
       //bd.insertar();      
       //bd.modificar("95"); //cuenta a cambiar       
        //bd.borrar("95");
       bd.control();
    }

public void borrar(String id){
String query= "delete from usuario where id ="+id;
int j=objConn.Update(query);
}

public void modificar(String id){
    String query = "Update usuario set usuario='fer', password='fergu' where id = "+id;
    int j=objConn.Update(query); //j numero de registros afectados por la accion
    System.out.println("Numero de registros afectados por la accion:"+j);
}

public void insertar(){
   String query = "Insert into usuario (id, usuario, password, privilegio)"
           + " values ('95','fernando','fer_95','2')";
   int j=objConn.Update(query);
   System.out.println("Numero de registros afectados por la accion:"+j);
}

public void control(){
    
    ArrayList <Usuarios> lista;
    ArrayList <Object> datosTabla;
    
    String query="Select * from usuario";
    objConn.Consult(query);
    int n=0;
        int i,j;
        if(objConn.rs!=null){
            try{
                objConn.rs.last(); //se posiciona en el ultimo registros de la tabla
                n=objConn.rs.getRow(); //regresa el numero actual del registro
                objConn.rs.first();
            }catch(Exception e){}
           lista = new ArrayList ();
            String user, pass;
            int id,priv;
            for(i=0;i<n;i++){ //n total de registros                
                    try{
                        id=objConn.rs.getInt(1);
                        user=objConn.rs.getString(2);
                        pass=objConn.rs.getString(3);
                        priv=objConn.rs.getInt(4);
                        lista.add(new Usuarios(id,user,pass,priv));
                        
                    }catch(Exception e){ }
                
                
                try{
                    objConn.rs.next();
                }catch(Exception e){}
            }
           
        objConn.closeRsStmt();
       
        System.out.println(lista);

        objConn.closeConnection();

    }

  }
}

//http://docs.oracle.com/javase/1.4.2/docs/api/java/sql/ResultSet.html
