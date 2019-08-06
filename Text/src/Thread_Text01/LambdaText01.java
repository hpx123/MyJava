package Thread_Text01;

public class LambdaText01 {
    public static void main(String[] args) {
        ILike i = new Like();
        }
    }

interface ILike{
    void lambda();
}
class Like implements ILike{

    @Override
    public void lambda() {

        System.out.println("i like lixian");
    }
}
