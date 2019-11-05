package com.ifmo.lesson10;
import java.util.*;

public class ClolectoinUnita {
    public static <T> Iterable<T> view(Iterable<T>... iterables) {
        if (iterables.length == 0) return List.of();
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int pos;
                    private Iterator<T> current;

                    @Override
                    public boolean hasNext() {
                        if (current == null)
                            current = iterables[pos].iterator();

                        if (!current.hasNext()) {
                            pos++;

                            if (pos < iterables.length) {
                                current = iterables[pos].iterator();
                            } else {
                                return false;
                            }
                        }
                        return current.hasNext();

                    }

                    @Override
                    public T next() {
                        return current.next();
                    }

                };
            }

        };
    }


        //itetable[] iterables
        //iterable arg
        //hasNext();  проверяет, есть ли итератор (в конце вернет false)
        //Next(); текущий итератор (в конце вернет true, если итератор в конце)
//        ArrayList<T> arg = new ArrayList<>();
        //      for(Iterable<T> iterable : iterables) {
        //        for (T t : iterable) {
        //          arg.add(t);
        //    }
        //      }
        //   return arg;
        // }
        public static void main (String[] args){
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new LinkedList<>();
            List<String> list3 = new LinkedList<>();

            list1.add("1");
            list1.add("2");

            list2.add("3");
            list2.add("4");

            list3.add("5");
            list3.add("6");

            Iterable<String> view = view(list1, list2, list3);

            for (String s : view) {
                System.out.println(s); // 1 ... 6
            }
        }
    }

