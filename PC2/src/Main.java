import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        //1. Dada una lista de números enteros aleatorios, imprimir todos los números pares que
        //existen en la lista usando las funciones Stream. (1pto.)
        List<Integer> numAlea = Stream.generate(() -> r.nextInt(0,100))
                .limit(10).filter(e->e%2==0)
                .collect(Collectors.toList());
        System.out.println(numAlea);

        //2. Dada una lista de números enteros aleatorios, imprimir todos los números que
        //comienzan con 5 usando las funciones Stream. (1pto.)
        List<Integer> numAlea1 = Stream.generate(() -> r.nextInt(0,100))
                .limit(10).filter(e->e.toString().startsWith("5")).toList();

        System.out.println(numAlea1);

        //3. Dada una lista de números enteros aleatorios, imprimir todos los números
        //duplicados usando las funciones Stream. (1pto.)
        //List<Integer> numAlea2 = Stream.generate(() -> r.nextInt(0,100))
              //  .limit(10).;


        //4. Dada una lista de números enteros aleatorios, imprimir el número total de
        //elementos presentes en la lista usando funciones Stream. (1pto.)
        long conteo = Stream.generate(() -> r.nextInt(0,100))
                .limit(10).count();
        System.out.println("numero de elementos presentes: "+ conteo);

        //5. Dada una lista de números enteros aleatorios, imprime todos los valores presentes
        //en ella en orden descendente utilizando las funciones Stream. (1pto.)
        List<Integer> numAlea3 = Stream.generate(() -> r.nextInt(0,100))
                .limit(10).sorted().collect(Collectors.toList());
        System.out.println(numAlea3);

        //6. Dado un array de números enteros, devuelve true si algún valor aparece al menos
        //tres veces en el array y devuelve falso si cada elemento es distinto. (1.5 ptos.)
        boolean treValores = Stream.generate(() -> r.nextInt(0,100))
                .limit(10)
                .collect((Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .values().stream().anyMatch(c -> c>=3);
        System.out.println(treValores);

        //7. Dado dos arrays de cadenas, se desea concatenar. Por ejemplo: A[n] =
        //{1,2,3,4,5,8,23} y B[m] = {4,6,8,0,2}, AB[n + m] = {1,2,3,4,5,8,23,4,6,8,0,2} (1.5
        //ptos.)

        int[] A ={1,2,3,4,5,8,23};
        int[] B ={4,6,8,0,2};
            int[] AB = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).toArray();
        System.out.println(Arrays.toString(AB));

        //8. Dado una lista de números enteros aleatorios, calcular el cubo de los números de
        //los elementos de lista y filtrar números mayores a 50. (1pto.)

        List<Integer> numAlea4 = Stream.generate(() -> r.nextInt(0,4))
                .limit(10).map(i -> i*i*i).filter(u->u>50).collect(Collectors.toList());
        System.out.println(numAlea4);


        //9. ¿Cómo contabilizar el total de todos las palabras de un arreglo de cadena? (1pto.)
        String letra = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int arreglo = (int) Stream.generate(() -> {
            String charr= Stream.generate(() -> {
                        int num = r.nextInt(0,letra.length());
                        String c= String.valueOf(letra.charAt(num));
                        return c;
                    }).limit(8)
                    .map(Objects::toString)
                    .collect(Collectors.joining());
            return charr;
            }).limit(r.nextInt(0,10)).count();
        System.out.println(arreglo);



    }
}