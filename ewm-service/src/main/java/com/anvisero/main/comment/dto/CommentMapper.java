package com.anvisero.main.comment.dto;

import com.anvisero.main.comment.model.Comment;
import com.anvisero.main.comment.model.CommentStatus;
import com.anvisero.main.event.model.Event;
import com.anvisero.main.user.dto.UserMapper;
import com.anvisero.main.user.model.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class CommentMapper {

    public CommentOutputDto commentToCommentOutputDto(final Comment comment) {
        return CommentOutputDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .created(comment.getCreated())
                .author(UserMapper.userToOutputUserDto(comment.getAuthor()))
                .eventId(comment.getEvent().getId())
                .status(comment.getStatus())
                .build();
    }

    public Comment commentInputDtoToComment(final CommentInputDto commentInputDto, final User user, final Event event) {
        return Comment.builder()
                .created(LocalDateTime.now())
                .text(commentInputDto.getText())
                .author(user)
                .event(event)
                .status(CommentStatus.MODERATION)
                .build();
    }
}