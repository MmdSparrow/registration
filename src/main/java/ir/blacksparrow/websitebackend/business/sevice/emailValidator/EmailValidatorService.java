package ir.blacksparrow.websitebackend.business.sevice.emailValidator;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidatorService implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // todo:
        return true;
    }
}
