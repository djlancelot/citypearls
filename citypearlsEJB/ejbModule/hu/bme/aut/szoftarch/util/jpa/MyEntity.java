package hu.bme.aut.szoftarch.util.jpa;

public abstract class MyEntity {

   public static boolean isId(Integer id) {
        return (id != null && id > 0);
    }
 
    public boolean hasId() {
        return isId(getId());
    }
 
    public abstract Integer getId();
}
