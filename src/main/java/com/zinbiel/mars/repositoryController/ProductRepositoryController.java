package com.zinbiel.mars.repositoryController;

import com.zinbiel.mars.dao.ProductDao;
import com.zinbiel.mars.data.ProductEntity;
import com.zinbiel.mars.restdata.ExchangeRestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by elias on 04.09.17.
 */

@RepositoryRestController
@RequestMapping("/product")
public class ProductRepositoryController {

    private final ProductDao productDao;
    @Autowired private PagedResourcesAssembler pagedResourcesAssembler;
    @Autowired private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryController.class);

    @Autowired
    public ProductRepositoryController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody PersistentEntityResource postProducts(@RequestBody ProductEntity product, PersistentEntityResourceAssembler resourceAssembler){

        if (product.getPrice().getCurrency().contains("EUR")){
            product = productDao.save(product);
            return resourceAssembler.toResource(product);
        } else {
            // We convert the currency to EUR
            ExchangeRestData data = restTemplate.getForObject("https://api.fixer.io/latest", ExchangeRestData.class);
            if (!data.getRates().containsKey(product.getPrice().getCurrency())){
                throw new ResourceNotFoundException(product.getPrice().getCurrency() + " not a valid currency");
            }

            Float rate = data.getRates().get(product.getPrice().getCurrency());
            product.getPrice().setCurrency("EUR");
            Float oldPrice = product.getPrice().getPrice();
            product.getPrice().setPrice(oldPrice / rate);
            product = productDao.save(product);
            return resourceAssembler.toResource(product);
        }
    }

}
