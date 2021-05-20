package Service;

import org.beryx.textio.InputReader.ValueChecker;

import java.util.ArrayList;
import java.util.List;

public class DanishPhoneNumberValueChecker<T> implements ValueChecker<T> {

    @Override
    public List<String> getErrorMessages(Object o, String s) {
        List<String> list = new ArrayList<>();
        list.add("Phone number can only contain digits and must be 8 digits long.");
        return list;
    }

}
