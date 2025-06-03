package com.example.expensetracker.controller;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.Category;
import com.example.expensetracker.service.ExpenseService;
import com.example.expensetracker.service.UserService;
import com.example.expensetracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody ExpenseRequest request) {
        Optional<User> userOpt = userService.getUserById(request.getUserId());
        Optional<Category> categoryOpt = categoryService.getCategoryById(request.getCategoryId());
        if (userOpt.isEmpty() || categoryOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid user or category ID");
        }
        Expense expense = Expense.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .date(request.getDate())
                .user(userOpt.get())
                .category(categoryOpt.get())
                .build();
        return ResponseEntity.ok(expenseService.createExpense(expense));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseRequest request) {
        Optional<User> userOpt = userService.getUserById(request.getUserId());
        Optional<Category> categoryOpt = categoryService.getCategoryById(request.getCategoryId());
        if (userOpt.isEmpty() || categoryOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid user or category ID");
        }
        Expense expense = Expense.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .date(request.getDate())
                .user(userOpt.get())
                .category(categoryOpt.get())
                .build();
        try {
            return ResponseEntity.ok(expenseService.updateExpense(id, expense));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    // DTO for request
    public static class ExpenseRequest {
        private java.math.BigDecimal amount;
        private String description;
        private java.time.LocalDate date;
        private Long userId;
        private Long categoryId;
        // getters and setters
        public java.math.BigDecimal getAmount() { return amount; }
        public void setAmount(java.math.BigDecimal amount) { this.amount = amount; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public java.time.LocalDate getDate() { return date; }
        public void setDate(java.time.LocalDate date) { this.date = date; }
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getCategoryId() { return categoryId; }
        public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    }
} 