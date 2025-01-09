package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.RoomService;
import infrastructure.persistence.entities.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final RoomService roomService;

    @Autowired
    public RoomGraphQLResolver(RoomService roomService) {
        this.roomService = roomService;
    }

    //////Query
    public RoomEntity getRoomById(final long id) {
        return roomService.getRoomById(id).orElseGet(null);
    }

    public List<RoomEntity> getRooms() {
        return roomService.getAllRooms();
    }

    /// ///Mutation
    public RoomEntity createRoom(final RoomEntity roomEntity) {
        return roomService.createRoom(roomEntity);
    }

    public RoomEntity updateRoom(final long id, final RoomEntity roomEntity) {
        return roomService.updateRoom(id, roomEntity);
    }

    public boolean deleteRoom(final long id) {
        return roomService.deleteRoom(id);
    }

}
