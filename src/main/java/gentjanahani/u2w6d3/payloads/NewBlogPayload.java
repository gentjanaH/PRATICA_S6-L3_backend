package gentjanahani.u2w6d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewBlogPayload {
    private String category;
    private String title;
    private String content;
    private int readingTime;
    private String authorId;
}
