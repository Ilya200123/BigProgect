import java.util.Objects;
import java.util.stream.Stream;

public  enum Action {


    Exit(0, false),
    create(1, true),
    update(2, true),
    delete(3, true),
    statistic(4, false),
    statisticDZ(5,true),
    search(6, true),
    error(-1, false);


    Action(Integer code, boolean requiredData) {
        this.code = code;
        this.requiredData = requiredData;
    }

    private Integer code;
    private boolean requiredData;

    public Integer getCode() {
        return code;
    }

    public boolean isRequiredData() {
        return requiredData;
    }


    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный" + code);
                    return Action.error;
                });
    }

}


