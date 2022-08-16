package BinaryPackage;

public class BinarySearchTreeDirectory {
    
     private BinarySearchTreeNode node;

    public void put(String directory, Object value ){
        if ( node == null ){
            
            node = new BinarySearchTreeNode( directory, value );
            
        }else{
            node.put( directory, value );
        }
    }
    public Object getDirectory(String directory ){
        
        return node == null ? null : node.getDirectory( directory );
    }
}

