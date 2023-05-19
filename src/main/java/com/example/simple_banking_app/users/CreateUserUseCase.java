package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.exceptions.CreatePersonInputError;
import com.example.simple_banking_app.users.api.exceptions.UserNotFound;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
class CreateUserUseCase {
    private final UserRepository userRepository;
    private final AccountFacade accountFacade;

    private static final Logger log = LoggerFactory.getLogger(CreateUserUseCase.class);

    CreateUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        this.userRepository = userRepository;
        this.accountFacade = accountFacade;
    }

    public String execute(CreateUser createUser) {
        validate(createUser);
        var userEntityToSave = new UserEntity();

        userEntityToSave.setName(createUser.name());
        userEntityToSave.setSurname(createUser.surname());
        userEntityToSave.setPesel(createUser.pesel());

        var userEntity = userRepository.save(userEntityToSave);
        accountFacade.createAccountsForUserId(new CreateAccount(userEntity.getPesel(), createUser.amountOfPLN()));
        return userEntity.getPesel();
    }

    private void validate(CreateUser createUser) {
        // TODO we can return potential errors from each validation and return them as a List of errors.
        try {
            validatePesel(createUser.pesel());
            validateName(createUser.name());
            validateSurname(createUser.surname());
        } catch (Exception e) {
            log.error(String.valueOf(e));
            throw e;
        }
    }


    private void validatePesel(String pesel) {
        validatePeselIsFormattedProperly(pesel);
        validatePersonIsOlderThen18YearsOld(pesel);
        validatePeselIsUnique(pesel);
    }

    private void validatePeselIsFormattedProperly(String pesel) {
        if (pesel == null || pesel.length() != 11 || first6LettersHaveDateEncoded(pesel) || allCharactersAreNumbers(pesel)) {
            throw new CreatePersonInputError(String.format("Pesel is wrongly formated %s", pesel));
        }
    }

    private boolean allCharactersAreNumbers(String pesel) {
        // TODO to implement
        return false;
    }

    private boolean first6LettersHaveDateEncoded(String pesel) {
        // TODO to implement
        return false;
    }

    private void validatePersonIsOlderThen18YearsOld(String pesel) {
        //TODO
    }

    private void validatePeselIsUnique(String pesel) {
        if (userRepository.existsByPesel(pesel)) {
            throw new UserNotFound(String.format("Pesel is not unique %s", pesel));
        }
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new CreatePersonInputError(String.format("Name is wrongly formated %s", name));
        }
    }

    private void validateSurname(String surname) {
        if (surname.isEmpty()) {
            throw new CreatePersonInputError(String.format("Pesel is wrongly formated %s", surname));
        }
    }
}
