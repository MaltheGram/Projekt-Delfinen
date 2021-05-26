package Service;


import java.util.Random;

public class MemberIdGenerator {

    private final Integer randomId;
    private final String hexStringId;

    public MemberIdGenerator(){
        this.randomId = generateRandom();
        this.hexStringId = Integer.toHexString(randomId);

}

    private Integer generateRandom(){
        return Math.abs(new Random().nextInt(500));
    }

    private String getHexStringId(){
        return hexStringId;
    }

    @Override
    public String toString() {
        return randomId + hexStringId;
    }
}
