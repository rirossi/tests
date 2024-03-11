Ways to INIT:
```
standard:
int[] array = {1, 2, 3};
int array[] = new int[1];

streams:
IntStream.range(1, size)
                .boxed()
                .mapToInt(integer -> array[size - integer])
                .toArray()
```


Sort
```
    public class SortByArrival implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.foo - o2.foo;
        }
        
        
    Arrays.sort(array, new SortByArrival());
```


Merge
```
    int[] a = {1, 2};
    int[] b = {3, 4};
    int[] result = Arrays.copyOf(a, 4);
    System.arraycopy(b, 0, result, 2, 4);
```

Convert
```
Arrays.stream(ints).boxed().collect(Collectors.toList());
```