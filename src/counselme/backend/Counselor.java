import java.time.Instant;
import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import codeu.model.store.basic.MessageStore;
import codeu.model.store.basic.ConversationStore;
import codeu.model.store.basic.UserStore;


/** Don't forget to make isAdmin A private static final*/

/** Class representing a registered Counselor. */
public class Counselor {

  private final UUID id;
  private final String name;
  private final String hashedPassword;
  private final Instant creation;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.systemDefault());
  private List<Message> messagesSent;

  
  /**
   * Constructs a new Counselor.
   *
   * @param id the ID of this Counselor
   * @param name the username of this Counselor
   * @param password the password of this Counselor
   * @param creation the creation time of this Counselor
   */
  public Counselor(UUID id, String name, String hashedPassword, String bio, Instant creation) {
    this.id = id;
    this.name = name;
    this.hashedPassword = hashedPassword;
    this.bio = bio;
    this.creation = creation;
    messagesSent = new ArrayList<>();
  }

  /** Returns the ID of this Counselor. */
  public UUID getId() {
    return id;
  }

  /** Returns the username of this Counselor. */
  public String getName() {
    return name;
  }

  /** Returns the password of this Counselor. */
  public String getPassword() {
    return hashedPassword;
  }

  /** Returns the creation time of this Counselor. */
  public Instant getCreationTime() {
    return creation;
  }
  
  //returns a readable string representing Counselor's registration time
  public String getReadableCreationTime() {
	  return formatter.format(getCreationTime());
  }
  
  public int numMessagesSent() {
	  if(messagesSent == null) return 0;
	  return messagesSent.size();
  }
  
  public void addMessage(Message message) {
	  messagesSent.add(message);
  }
  
  public List<Message> getMessagesSent() {
	  return messagesSent;
  }
  
  //used for storing messagesSent in persistant data store. Not used for now because of issue with message Ids changing when loaded.
//  public String getMessagesSentAsString() {
//	  String out = "";
//	  for(Message message : messagesSent) {
//		  out += (message.getId().toString() + ",");
//	  }
//	  return out;
//  }
//  
//  public void setMessagesSent(String messageIds) {
//	  if(messageIds == null) return;
//	  String[] uuidStrings = messageIds.split(",");
//	  for(String id : uuidStrings) {
//		  if(!id.equals("")) {
//			  System.out.println(id);
//			  addMessage(MessageStore.getInstance().getMessage(UUID.fromString(id)));
//		  }
//	  }
//  }
  
  
}
