package API.dto;

import com.google.gson.annotations.SerializedName;
import dto.Account;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class AccountsList {
    @SerializedName("recentItems")
    private ArrayList<Account> accountList;
}