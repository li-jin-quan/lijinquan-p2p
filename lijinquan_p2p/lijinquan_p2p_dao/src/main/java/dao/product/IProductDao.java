package dao.product;

import cn.lijinquan.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lijinquan on 2019/5/7.
 */
public interface IProductDao extends JpaRepository<Product,Long> {
}
