package gin.misc;


import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.modules.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import gin.SourceFileTree;
import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;
import java.util.Optional;

/**
 * A visitor that clones (copies) a node and all its children.
 * Extended to copy IDs as well.
 */
public class CloneVisitorCopyIDs extends CloneVisitor {

    private final Map<Integer, Node> nodesToReplace;

    public CloneVisitorCopyIDs() {
        nodesToReplace = new HashedMap<>();
    }

    public CloneVisitorCopyIDs(Map<Integer, Node> nodesToReplace) {
        this.nodesToReplace = new HashedMap<>();
        this.nodesToReplace.putAll(nodesToReplace);
    }

    @Override
    public Visitable visit(final CompilationUnit n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((CompilationUnit) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final PackageDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((PackageDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final TypeParameter n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((TypeParameter) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final LineComment n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((LineComment) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final BlockComment n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((BlockComment) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ClassOrInterfaceDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ClassOrInterfaceDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final EnumDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((EnumDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final EnumConstantDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((EnumConstantDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final AnnotationDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((AnnotationDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final AnnotationMemberDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((AnnotationMemberDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final FieldDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((FieldDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final VariableDeclarator n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((VariableDeclarator) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ConstructorDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ConstructorDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final MethodDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((MethodDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final Parameter n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((Parameter) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final InitializerDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((InitializerDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final JavadocComment n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((JavadocComment) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ClassOrInterfaceType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ClassOrInterfaceType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final PrimitiveType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((PrimitiveType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ArrayType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ArrayType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ArrayCreationLevel n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ArrayCreationLevel) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final IntersectionType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((IntersectionType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final UnionType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((UnionType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final VoidType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((VoidType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final WildcardType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((WildcardType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final UnknownType n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((UnknownType) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ArrayAccessExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ArrayAccessExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ArrayCreationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ArrayCreationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ArrayInitializerExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ArrayInitializerExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final AssignExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((AssignExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final BinaryExpr n, final Object arg) {
        if (n.containsData(SourceFileTree.NODEKEY_ID)) {
            Integer id = n.getData(SourceFileTree.NODEKEY_ID);

            if (nodesToReplace.containsKey(id)) {
                Node r = nodesToReplace.get(id);
                return r;
            }

            Visitable r = checkForReplacement(n);
            if (r == null) {
                r = super.visit(n, arg);
                if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                    ((BinaryExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
                }
            }
            return r;
        } else {
            return null;
        }
    }

    @Override
    public Visitable visit(final CastExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((CastExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ClassExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ClassExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ConditionalExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ConditionalExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final EnclosedExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((EnclosedExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final FieldAccessExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((FieldAccessExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final InstanceOfExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((InstanceOfExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final StringLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((StringLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final IntegerLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((IntegerLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final LongLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((LongLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final CharLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((CharLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final DoubleLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((DoubleLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final BooleanLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((BooleanLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final NullLiteralExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((NullLiteralExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final MethodCallExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((MethodCallExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final NameExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((NameExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ObjectCreationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ObjectCreationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final Name n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((Name) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SimpleName n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SimpleName) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ThisExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ThisExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SuperExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SuperExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final UnaryExpr n, final Object arg) {
        if (n.containsData(SourceFileTree.NODEKEY_ID)) {
            Integer id = n.getData(SourceFileTree.NODEKEY_ID);
            if (nodesToReplace.containsKey(id)) {
                Node r = nodesToReplace.get(id);
                //r.setData(SourceFileTree.NODEKEY_ID, id);
                return r;
            }

            Visitable r = checkForReplacement(n);
            if (r == null) {
                r = super.visit(n, arg);
                if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                    ((UnaryExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
                }
            }

            return r;
        } else {
            return null;
        }
    }

    @Override
    public Visitable visit(final VariableDeclarationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((VariableDeclarationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final MarkerAnnotationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((MarkerAnnotationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SingleMemberAnnotationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SingleMemberAnnotationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final NormalAnnotationExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((NormalAnnotationExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final MemberValuePair n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((MemberValuePair) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ExplicitConstructorInvocationStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ExplicitConstructorInvocationStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final LocalClassDeclarationStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((LocalClassDeclarationStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final AssertStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((AssertStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final BlockStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((BlockStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final LabeledStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((LabeledStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final EmptyStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((EmptyStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ExpressionStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ExpressionStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SwitchStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SwitchStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SwitchEntry n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SwitchEntry) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final BreakStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((BreakStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ReturnStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ReturnStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final IfStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((IfStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final WhileStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((WhileStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ContinueStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ContinueStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final DoStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((DoStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ForEachStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ForEachStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ForStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ForStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ThrowStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ThrowStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final SynchronizedStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((SynchronizedStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final TryStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((TryStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final CatchClause n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((CatchClause) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final LambdaExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((LambdaExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final MethodReferenceExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);
            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((MethodReferenceExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final TypeExpr n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((TypeExpr) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Node visit(final ImportDeclaration n, final Object arg) {
        Node r = super.visit(n, arg);
        if (n.containsData(SourceFileTree.NODEKEY_ID)) {
            r.setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
        }
        return r;
    }

    @Override
    public Visitable visit(final ModuleDeclaration n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleDeclaration) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ModuleRequiresDirective n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleRequiresDirective) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    protected <T extends Node> T cloneNode(Optional<T> node, Object arg) {
        return super.cloneNode(node, arg);
    }

    @Override
    protected <T extends Node> T cloneNode(T node, Object arg) {
        return super.cloneNode(node, arg);
    }

    @Override
    public Visitable visit(final ModuleExportsDirective n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleExportsDirective) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ModuleProvidesDirective n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleProvidesDirective) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ModuleUsesDirective n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleUsesDirective) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final ModuleOpensDirective n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((ModuleOpensDirective) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    @Override
    public Visitable visit(final UnparsableStmt n, final Object arg) {
        Visitable r = checkForReplacement(n);
        if (r == null) {
            r = super.visit(n, arg);

            if (n.containsData(SourceFileTree.NODEKEY_ID)) {
                ((UnparsableStmt) r).setData(SourceFileTree.NODEKEY_ID, n.getData(SourceFileTree.NODEKEY_ID));
            }
        }

        return r;
    }

    private Node checkForReplacement(Node n) {
        if (n.containsData(SourceFileTree.NODEKEY_ID)) {
            Integer id = n.getData(SourceFileTree.NODEKEY_ID);
            if (nodesToReplace.containsKey(id)) {
                Node r = nodesToReplace.get(id);
                return r;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
