package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookServices {

    @Autowired
private BookRepository bookRepository;






    //    private static List<Book> list = new ArrayList<>();

//    static{
//     list.add(new Book(1, "Java Complete Refrerence", "xyz"));
//     list.add(new Book(2, "Head First to Java", "xyz"));
//     list.add(new Book(3, "Think in java", "xyz"));
//    }

//get all book
public List<Book> getAllBooks(){
  List<Book>  list=(List<Book>)this.bookRepository.findAll();
  return list;
}

//get single book b Id
public Book getBookById(int id){
    Book book=null;

    try {
       book=this.bookRepository.findById(id);
       
        // book=list.stream().filter(e->e.getId()==id).findFirst().get();
        } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    
    return book;
}

//adding Book
public Book addBook(Book b){
    
    Book result=bookRepository.save(b);
    // list.add(b);
    return result;
    }

//Deleting
public void deleteBook(int bid){
//     list=list.stream().filter(book-> book.getId()!=bid)
//     .collect(Collectors.toList());
// 
bookRepository.deleteById(bid);
}

//Updating book
public void updateBook(Book book, int bookId){


book.setId(bookId);
bookRepository.save(book);

    //     list=list.stream().map(b->{
//      if(b.getId()==bookId){
//         b.setTitle(book.getTitle());
//         b.setAuthor(book.getAuthor());
//      }
//      return b;
//     }).collect(Collectors.toList());

// }
}   
}













 