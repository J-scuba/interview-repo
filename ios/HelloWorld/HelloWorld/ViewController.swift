import UIKit

final class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()

        view.backgroundColor = .systemBackground

        let greeting = UILabel()
        greeting.text = "Hello, world!"
        greeting.textColor = .systemGreen
        greeting.font = .preferredFont(forTextStyle: .largeTitle)
        greeting.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(greeting)

        NSLayoutConstraint.activate([
            greeting.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            greeting.centerYAnchor.constraint(equalTo: view.centerYAnchor)
        ])
    }
}