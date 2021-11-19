package hello.itemservice.domain.item;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원 넘게 입력헤주세요.") global 그냥 안쓰는게 좋음
public class Item {

//    @NotNull(groups = UpdateCheck.class)
    private Long id;

//    @NotBlank(groups = {SaveCheck.class,UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Range(min = 1000, max = 100000)
    private Integer price;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Max( value = 9999,groups = SaveCheck.class)
    private Integer quantity;


    public Item() {
    }

    public void ItemCreate(ItemSaveForm form){
        itemName = form.getItemName();
        price = form.getPrice();
        quantity = form.getQuantity();
    }


    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
