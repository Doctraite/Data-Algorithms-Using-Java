<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.*"%>
<%@page import="BinaryPackage.BinarySearchTreeDirectory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mbabane Municipality Transport System</title>
</head>
<body>    
<%!
        public boolean available = false;
        public String username;
        public String latest;
        public int company=0;
        public BinarySearchTreeDirectory dance = new BinarySearchTreeDirectory();


     public void delete(String old,String news){

        File fileToBeModified_1 = new File("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
        String details = ""; 
        BufferedReader reader = null;
        FileWriter writer = null;
      try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified_1));
            String line = reader.readLine();
            while (line != null) 
            {
                details = details + line + System.lineSeparator();
                line = reader.readLine();
            }  
                String newContent = details.replaceAll(old, news);
                writer = new FileWriter(fileToBeModified_1);
                writer.write(newContent);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close(); 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
         }

            File fileToBeModified = new File("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
            String oldContent = "";
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) 
            {
            if(line.equals("")){
              }else{
                   oldContent = oldContent + line + System.lineSeparator();
              }
                   line = reader.readLine();
            }            
                   String newContent = oldContent; 
                   writer = new FileWriter(fileToBeModified);
                   writer.write(newContent);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {                 
                reader.close();    
                writer.close();
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
}

public void update(String old,String news){

        File fileToBeModified = new File("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
        String oldContent = ";";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();    
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(old, news);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }

}


        String search_bst(String name){
        String result="";
        company =0;
        available = false;
        FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                String cc = String.valueOf(company);
                line = reader.readLine();
                dance.put(cc, line);
                company++; 
            } 
                company--;
                System.out.println("Added Value"+String.valueOf(company));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
            }
}

            for(int i=0; i<company;i++){
            String tev = String.valueOf(i);
            String str = dance.getDirectory(tev).toString();
            if(str.equals(name)){
            available = true;
            System.out.println("User Name: "+name);
            result = " User Exists In The File";
            }
            }
            if(available==false){
            result = "USER NOT FOUND";
            }

            return result;
     }

    public void print_all(){

                    FileInputStream fis = null;
                    BufferedReader reader = null;
        try {
            fis = new FileInputStream("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while(line != null){
       }
        } catch (FileNotFoundException ex) {   
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
               
            }
        }
}
          public void add_user(String username){
                       try {   
                            File file = new File("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
                            FileWriter fw = new FileWriter(file,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(username);
                            bw.newLine();
                            bw.close();
                            } catch(IOException ex) {
                            }
                    }
     public void add_to_BST(String username){

        FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                String cc = String.valueOf(company);
                company++; 
                line = reader.readLine();
                dance.put(cc, line);
            } 
               company = company-1;
               System.out.println("TOTAL DETAILS"+String.valueOf(company));
        } catch (FileNotFoundException ex) {     
        } catch (IOException ex) {  
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {            
            }
        }
  }
        %>
<%
    
   if (request.getParameter("searchUsers") != null){
       username = request.getParameter("search");
       out.println(search_bst(username));
   }
   if (request.getParameter("addUsers") != null){
       username = request.getParameter("add");
       add_user(username);
       add_to_BST(username);
       out.println("Successfully Added New User");
   }
 
    if (request.getParameter("updateUsers") != null){
       username = request.getParameter("update");
       latest = request.getParameter("new");
       out.println("Successfully Updated User Details");
       update(username,latest);
   }
   
   if (request.getParameter("deleteUsers") != null){
       username = request.getParameter("delete");
       out.println("Successfully Deleted User From File");
       delete(username,"");
   }
   if (request.getParameter("printUsers") != null){
       FileInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new FileInputStream("C:\\Users\\fana\\Documents\\NetBeansProjects\\dataAlgorithms\\web\\directory.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            out.println("Mbabane Municipality Transport System User List"+"<br>");
            out.println("************************************************"+"<br>");
            while(line != null){
                line = reader.readLine();
                if(line!=null){
                out.println(line+"<br>");
}
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
            }
   }
}

%>
</body>
</html>
