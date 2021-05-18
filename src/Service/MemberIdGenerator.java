package Service;


import java.util.Random;

public class MemberIdGenerator {

    private final Integer ranmdomId;
    private final String hexStringId;

    public MemberIdGenerator(){
        this.ranmdomId = generateRandom();
        this.hexStringId = Integer.toHexString(ranmdomId);

}

    private Integer generateRandom(){
        return Math.abs(new Random().nextInt(500));
    }

    private String getHexStringId(){
        return hexStringId;
    }

    @Override
    public String toString() {
        return ranmdomId + hexStringId;
    }
}
