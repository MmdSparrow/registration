package ir.blacksparrow.websitebackend.view.controller;

public class ControllerValidator {
    public static boolean isValidSizeOffset(String size,String offset){
        if((size == null && offset != null) || (size!=null && offset == null)) return false;
        else if(size != null)
            try{
                if(Integer.parseInt(offset) < 1)
                    return false;
                else if(Integer.parseInt(size) < 1)
                    return false;
            }catch (Exception e){
                return false;
            }

        return true;
    }
}
