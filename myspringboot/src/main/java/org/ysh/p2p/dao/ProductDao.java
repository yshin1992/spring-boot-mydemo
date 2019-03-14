package org.ysh.p2p.dao;

import org.ysh.p2p.model.Product;
import org.ysh.p2p.vo.PageRequest;
import org.ysh.p2p.vo.PageResponse;
import org.ysh.p2p.vo.ProductDto;

public interface ProductDao extends AbstractDao<Product>{

	public PageResponse<Product> queryByPage(PageRequest request,ProductDto dto);
	
}
