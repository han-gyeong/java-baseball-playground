package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayListTest {

    @Test
    void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("TOM");
        values.add("James");

        assertThat(values).containsExactly("TOM", "James");

        assertThat(values.get(0)).isEqualTo("TOM");

        assertThat(values).hasSize(2);

        assertThat(values).isNotEmpty();
    }

    @Test
    void hashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Hello");
        assertThat(hashMap).containsEntry(1, "Hello");
        assertThat(hashMap.get(2)).isNull();
        assertThat(hashMap).hasSize(1);
        assertThat(hashMap).containsKey(1);

        hashMap.remove(1);
        assertThat(hashMap).isEmpty();
    }
}
