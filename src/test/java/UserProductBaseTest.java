import org.junit.Test;
import ru.repositories.UserProductsBaseImpl;
import ru.users.UserProduct;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProductBaseTest {
    @Test
    public void getMethodShouldReturnProductFromServer() {
        UserProductsBaseImpl userProductsBase = new UserProductsBaseImpl("koliannn");
        Iterator<UserProduct> iterator = userProductsBase.getProductFromServer().iterator();
        while (iterator.hasNext()) {
            UserProduct userProduct = iterator.next();
            System.out.println(userProduct.getProductName() + " " + userProduct.getPrice());
        }
    }

    @Test
    public void addNewUserShouldCreateNewRowInSql() {

        UserProductsBaseImpl userProductsBase = new UserProductsBaseImpl("koliannn");

        List<UserProduct> userProductsList = new ArrayList<>();

        userProductsList.add(new UserProduct("Кеды", 200));

        userProductsList.add(new UserProduct("Штаны", 40));

        userProductsBase.addNewProducts(userProductsList);
    }
}
