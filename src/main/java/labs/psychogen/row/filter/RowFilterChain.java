package labs.psychogen.row.filter;

import labs.psychogen.row.domain.protocol.RequestDto;
import labs.psychogen.row.domain.protocol.ResponseDto;
import org.springframework.util.Assert;

import java.util.List;

public class RowFilterChain {
    private List<RowFilter> filters;

    public RowFilterChain(List<RowFilter> filters) {
        this.filters = filters;
        Assert.notNull(filters, "Filters cant be null");
        Assert.isTrue(filters.size() > 0, "Initial filter size cant be 0");
    }

    public void addFilter(RowFilter rowFilter){
        filters.add(rowFilter);
    }

    public void addFilterBefore(RowFilter rowFilter, Class before){
        for (RowFilter filter : filters) {
            if(filter.getClass().equals(before)){
                int i = filters.indexOf(filter);
                filters.add( i, rowFilter);
                return;
            }
        }
    }

    public void addFilterAfter(RowFilter rowFilter, Class after){
        for (RowFilter filter : filters) {
            if(filter.getClass().equals(after)){
                int i = filters.indexOf(filter);
                filters.add( i+1, rowFilter);
                return;
            }
        }
    }

    public void filter(RequestDto requestDto, ResponseDto response) throws Exception {
        for (RowFilter filter : filters) {
            if (!filter.filter(requestDto, response)) {
                return;
            }
        }
    }
}
