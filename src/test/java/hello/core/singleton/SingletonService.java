package hello.core.singleton;

public class SingletonService {
    // static 영역이어서 하나만 만들어짐
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance() {
        return instance;
    }
    // 생성자를 private으로 선언
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
