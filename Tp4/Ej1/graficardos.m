% Define shared X axis (input sizes)
x = [1000, 10000, 25000, 50000, 100000];

% Define Y values
y1 = [0.054, 0.725, 6.758, 30.526, 135.578];
y2 = [0.001, 0.006, 0.016, 0.03, 0.041];

% Plot with logarithmic Y scale
semilogy(x, y1, '-ob', 'LineWidth', 2, 'MarkerFaceColor', 'b');
hold on;

semilogy(x, y2, '-sr', 'LineWidth', 2, 'MarkerFaceColor', 'r');

% Vertical offset factor
offset = 1.75; % values < 1 move text downward

% Add labels to points
for i = 1:length(x)

    % Labels for Algorithm A
    text(x(i), y1(i) * offset, ...
        sprintf('(%d, %.3f)', x(i), y1(i)), ...
        'VerticalAlignment', 'top', ...
        'HorizontalAlignment', 'left', ...
        'FontSize', 10, ...
        'FontWeight', 'bold');

    % Labels for Algorithm B
    text(x(i), y2(i) * offset, ...
        sprintf('(%d, %.3f)', x(i), y2(i)), ...
        'VerticalAlignment', 'top', ...
        'HorizontalAlignment', 'left', ...
        'FontSize', 10, ...
        'FontWeight', 'bold');
end

% Labels and title
xlabel('Input Size (n)', 'FontSize', 12, 'FontWeight', 'bold');
ylabel('Time (seconds)', 'FontSize', 12, 'FontWeight', 'bold');
title('Performance Comparison', 'FontSize', 14, 'FontWeight', 'bold');

legend('Algorithm A', 'Algorithm B', ...
       'Location', 'northwest', ...
       'FontSize', 10);

grid on;
hold off;
