package com.demo.customer;


import com.hybris.cockpitng.editor.commonreferenceeditor.SampleReferenceEditorSearchFacade;
import com.hybris.cockpitng.search.data.SearchQueryData;
import com.hybris.cockpitng.search.data.pageable.Pageable;
import com.hybris.cockpitng.search.data.pageable.PageableList;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author cyclone
 */
public class DemoCustomerUserGroupReferenceSearchFacade extends SampleReferenceEditorSearchFacade<PrincipalGroupModel>
{
    private List<String> wishToSeeGroups = new ArrayList<>();

    @Override
    public Pageable<PrincipalGroupModel> search(final SearchQueryData searchQueryData)
    {
        Pageable<PrincipalGroupModel> tempResult = super.search(searchQueryData);
        List<PrincipalGroupModel> result = tempResult.getAllResults().stream().filter(principalGroupModel -> wishToSeeGroups.contains(principalGroupModel.getUid()))
                .collect(Collectors.toList());
        return new PageableList<>(result, searchQueryData.getPageSize(), PrincipalGroupModel._TYPECODE);
    }

    public List<String> getWishToSeeGroups()
    {
        return wishToSeeGroups;
    }

    @Required
    public void setWishToSeeGroups(List<String> wishToSeeGroups)
    {
        this.wishToSeeGroups = wishToSeeGroups;
    }
}
