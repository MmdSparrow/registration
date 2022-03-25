package ir.blacksparrow.websitebackend.ResouceBoundle;

import javax.servlet.http.HttpServletRequest;

public interface ILabelService {
    String getMessageByKey(String labelKey, HttpServletRequest request);
}
