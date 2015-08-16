package algorithms.tree.binary;

/**end of data we are going to store in the tree.
 */
public enum TreeDataType {
    
    INTEGER("Integer"),
    DOUBLE("Double"),
    STRING("String"),
    INVALID("Invalid");
    
    private String dataType;
    
    private TreeDataType(String dataType) {
        this.dataType = dataType;
    }
    
    public String toString() {
        return dataType;
    }
    
    public static TreeDataType fromString(String dataType){
        
        if(dataType == null)
            return null;
        
        for (TreeDataType type : TreeDataType.values()) {
            if (dataType.equalsIgnoreCase(type.dataType)) {
                return type;
            }
        }

        return INVALID;
    }

}
