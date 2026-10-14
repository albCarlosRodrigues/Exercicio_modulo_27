import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    private List<String> lista;

    public void executar() throws Exception {

        Class<?> classe = Class.forName("java.util.ArrayList");

        Constructor<?> construtor = classe.getConstructor();
        Object instancia = construtor.newInstance();

        lista = (List<String>) instancia;

        Method adicionar = classe.getMethod("add", Object.class);

        adicionar.invoke(lista, "Java");
        adicionar.invoke(lista, "Spring Boot");
        adicionar.invoke(lista, "Reflection");

        Method obterIterator = classe.getMethod("iterator");
        Object iterator = obterIterator.invoke(lista);

        Class<?> classeIterator = Class.forName("java.util.Iterator");

        Method hasNext = classeIterator.getMethod("hasNext");
        Method next = classeIterator.getMethod("next");

        while ((boolean) hasNext.invoke(iterator)) {
            Object valor = next.invoke(iterator);
            System.out.println(valor);
        }
    }

    public static void main(String[] args) throws Exception {
        Main programa = new Main();
        programa.executar();
    }
}
