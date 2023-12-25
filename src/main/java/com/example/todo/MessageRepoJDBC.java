package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.example.todo.domain.Message;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageRepoJDBC {
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public List <Message> getAll (){
        String getAll = "SELECT * FROM public.todo;";
        return namedJdbcTemplate.query(getAll, new MyEntityRowMapper());
    }
    public int add(Message massage){
        String saveTodo = """                
             INSERT INTO public.todo(name, descr)
             VALUES (:name, :descr);
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("name", massage.getText());
        params.put("descr", massage.getTag());
        return  namedJdbcTemplate.update(saveTodo, params);

    }
    private static class MyEntityRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message myEntity = new Message();
            myEntity.setId(rs.getInt("id"));
            myEntity.setText(rs.getString("name"));
            myEntity.setTag(rs.getString("descr"));
            // Map other fields as needed
            return myEntity;
        }

    }
}
