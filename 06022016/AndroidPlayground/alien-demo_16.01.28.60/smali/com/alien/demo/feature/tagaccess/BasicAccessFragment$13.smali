.class Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$13;
.super Ljava/lang/Object;
.source "BasicAccessFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;->markReadFieldError(Landroid/widget/EditText;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;

.field final synthetic val$et:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 352
    iput-object p1, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$13;->this$0:Lcom/alien/demo/feature/tagaccess/BasicAccessFragment;

    iput-object p2, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$13;->val$et:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 355
    iget-object v0, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$13;->val$et:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 356
    iget-object v0, p0, Lcom/alien/demo/feature/tagaccess/BasicAccessFragment$13;->val$et:Landroid/widget/EditText;

    const v1, 0x7f020049

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setBackgroundResource(I)V

    .line 357
    return-void
.end method
