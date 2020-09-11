package lk.sliit.hotelManagement.dao.kitchenDAO;


import lk.sliit.hotelManagement.entity.kitchen.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuDAO extends CrudRepository<Menu,Integer> {
    Menu findTopByOrderByMenuIdDesc();

    Iterable<Menu> findMenuByMenuId(int menuId);
}
