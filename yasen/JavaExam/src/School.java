
/**
 * Created by Yassen on 3/30/2016.
 */
public class School extends Institution {

    public School(){
        super();
    }

    public School(String name, String title){
        super(name, title);
    }

    @Override
    public int CountStudents() {
        return this.countStudents;
    }
}
