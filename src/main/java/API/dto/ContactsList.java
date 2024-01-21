package API.dto;

import com.google.gson.annotations.SerializedName;
import dto.Contact;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class ContactsList {
    @SerializedName("recentItems")
    private ArrayList<Contact> contactsList;
}