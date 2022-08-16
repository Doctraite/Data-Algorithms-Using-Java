package BinaryPackage;

public class BinarySearchTreeNode {
    
    private String directory;
    private Object value;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode( String directory, Object value ){
        this.directory = directory;
        this.value = value;
    }

    
    public void put( String directory, Object value ){
        
        if ( directory.compareTo( this.directory ) < 0 ){             
            if (left != null){ 
                
                left.put( directory, value ); 
                
            }else{
                
                left = new BinarySearchTreeNode( directory, value );             
            }  
            
        }else if( directory.compareTo( this.directory ) > 0){
            
            if ( right != null ){
                right.put( directory, value );
            }else{
                right = new BinarySearchTreeNode( directory, value );
            }
        } else{
            this.value = value;
        }
    }

    
    public Object getDirectory(String directory)
    {
        if ( directory.compareTo( this.directory ) < 0 ){
            
         return left == null ? null : left.getDirectory(directory);
        }
        if ( this.directory.equals(directory)){
          return value;
        }   
        else{
            
          return right == null ? null : right.getDirectory(directory);
        }
    }
}
