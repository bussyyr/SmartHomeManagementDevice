package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.RoomService;
import infrastructure.persistence.entities.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomQueryResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final RoomService roomService;

    @Autowired
    public RoomQueryResolver(RoomService roomService) {
        this.roomService = roomService;
    }

    //////Query
    public RoomEntity getRoomById(final long id) {
        return roomService.getRoomById(id).orElseGet(null);
    }

    public List<RoomEntity> getRooms() {
        return roomService.getAllRooms();
    }



}
