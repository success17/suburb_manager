package au.com.aupost.suburbmanager.api.services.suburb.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import au.com.aupost.suburbmanager.model.Suburb;

public class GetSuburbsTest extends SuburbTest {


    @Before
    public void setUp() throws Exception {
        buildBaseUrl();
    }

    @Test
    public void retrieveFirstPage() {

        // setup fixture
        String suburbsServiceUrl = buildSuburbsServiceUrl();
        
        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = template.exchange(suburbsServiceUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<Suburb> suburbs = entity.getBody().getContent();
        assertThat(suburbs.size(), equalTo(PAGE_SIZE));

    }

    @Test
    public void retrieveSecondPage() {

        // setup fixture
        String secondPageUrl = buildSecondPageUrl();
        
        // exercise SUT
        ResponseEntity<Resources<Suburb>> entity = template.exchange(secondPageUrl, HttpMethod.GET, null, createTypeReference());

        // verify
        Collection<Suburb> suburbs = entity.getBody().getContent();
        int numberOfSuburbs = (int) suburbRepository.count();
        assertThat(suburbs.size(), equalTo(numberOfSuburbs - PAGE_SIZE));
    }

    private String buildSecondPageUrl() {
        return buildSuburbsServiceUrl() + "?page=1&size=" + PAGE_SIZE;
    }


}
