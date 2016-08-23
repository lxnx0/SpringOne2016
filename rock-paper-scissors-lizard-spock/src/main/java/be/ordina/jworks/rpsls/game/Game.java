package be.ordina.jworks.rpsls.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@RedisHash(value = "games", timeToLive = 1800)
@AllArgsConstructor
public class Game implements Comparable<Game> {

    @Id
    @Indexed
    private Long id;

    private LocalDateTime start;
    private LocalDateTime end;
    private String playerOne;
    private String playerOneImage;
    private int playerOneMove;
    private String playerTwo;
    private String playerTwoImage;
    private int playerTwoMove;

    @Override
    public int compareTo(Game that) {
        if (this.start.compareTo(that.start) > 0) {
            return -1;
        } else if (this.start.compareTo(that.start) < 0) {
            return 1;
        }
        return 0;
    }
}
