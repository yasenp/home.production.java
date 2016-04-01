/**

 /**
 * Created by Yassen on 3/30/2016.
 */
public class Garden extends Institution {

    public Garden(){
        super();
    }

    public Garden(String name, String title){
        super(name, title);
    }

    @Override
    public int CountStudents() {
        return this.countStudents;
    }
}